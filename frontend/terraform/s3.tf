resource "aws_s3_object" "static_files" {
  for_each = fileset("../dist/", "*")
  bucket = aws_s3_bucket.mars_rover_bucket.id
  key = each.value
  source = "../dist/${each.value}"
  etag = filemd5("../dist/${each.value}")
  content_type = lookup(local.mime_types, regex("\\.[^.]+$", each.value), null)

}

resource "aws_s3_object" "static_files_assets" {
  for_each = fileset("../dist/assets", "*")
  bucket = aws_s3_bucket.mars_rover_bucket.id
  key = "assets/${each.value}"
  source = "../dist/assets/${each.value}"
  etag = filemd5("../dist/assets/${each.value}")
  content_type = lookup(local.mime_types, regex("\\.[^.]+$", each.value), null)
}

resource "aws_s3_bucket_public_access_block" "public_access" {
  bucket = aws_s3_bucket.mars_rover_bucket.id

  block_public_acls   = false
  block_public_policy = false
}

resource "aws_s3_bucket_policy" "policy" {
  bucket = aws_s3_bucket.mars_rover_bucket.id

  policy = <<POLICY
{
  "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "PublicReadGetObject",
            "Effect": "Allow",
            "Principal": "*",
            "Action": [
                "s3:GetObject"
            ],
            "Resource": [
                "arn:aws:s3:::${aws_s3_bucket.mars_rover_bucket.id}/*"
            ]
        }
    ]
}
POLICY
}

resource "aws_s3_bucket_website_configuration" "website_config" {
  bucket = aws_s3_bucket.mars_rover_bucket.id

  index_document {
    suffix = "index.html"
  }
}

locals {
  mime_types = jsondecode(file("mime.json"))
}

resource "aws_s3_bucket" "mars_rover_bucket" {
  bucket = "mars-rover-bucket-frontend"

}