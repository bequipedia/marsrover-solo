data "local_file" "lambda_jar" {
  filename = var.lambda_payload_filename
}

resource "aws_s3_object" "lambda_jar" {
  bucket = aws_s3_bucket.mars_rover_bucket.id
  key    = "mars-rover.jar"

  source = data.local_file.lambda_jar.filename

  etag = filemd5(data.local_file.lambda_jar.filename)
}

resource "aws_s3_bucket" "mars_rover_bucket" {
  bucket = "mars-rover-bucket"
}