terraform {
  required_providers {
    aws = {
      version = "5.6.2"
    }
    archive = {
      version = "2.4.0"
    }
  }

  backend "s3" {
    bucket         = "mars-rover-bucket-state"
    key            = "terraform.tfstate"
    region         = "eu-west-1"
    dynamodb_table = "mars-rover-practice-table"
  }

  required_version = "1.5.2"
}
provider "aws" {
  region = "eu-west-1"
}