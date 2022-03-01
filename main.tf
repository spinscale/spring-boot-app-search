terraform {
  required_version = ">= 0.12.29"

  required_providers {
    ec = {
      source  = "elastic/ec"
      version = "0.4.0"
    }
  }
}

provider "ec" {
}

resource "ec_deployment" "spring-boot-app-search" {
  name                   = "spring-boot-app-search"

  region                 = "azure-westeurope"
  version                = "8.0.0"
  # do not use any appsearch deployment template ids, those are not for 8.0.0
  deployment_template_id = "azure-memory-optimized"

  elasticsearch {}

  kibana {}

  integrations_server {}

  enterprise_search {}
}
