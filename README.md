<img align="right" src="https://raw.githubusercontent.com/brandmaker/MediaPoolWebHookConsumer/master/BrandMaker_Logo_on_light_bg.png" alt="BrandMaker" width="30%" height="30%">

# BrandMaker boomi Connector Example

## Motivation

In order to connect the BrandMaker modules _Marketing Planner_ and _Job Manager_ with 3rd party applications, the integration with the Dell Boomi platform is offered. For more details on the iPaaS platform Dell Boomi please refer to the [documentaion](https://help.boomi.com/bundle/connectors/page/c-atm-Connectors.html).

## Scope

This repository contains a connector example for the IPaaS platform Dell Boomi. The connector is able to retrieve BrandMaker Marketing Planner Nodes and filter them as well as create new Workflow Jobs in BrandMaker Job Manager. Not all available API end points of these modules are implemented as this is mainly an example on how to implement a more specific connector.

## Prerequisits

Please make yourself familiar on the [boomi connector architecture](https://help.boomi.com/bundle/connectors/page/int-Custom_connector_architecture_and_components.html) and how to [set up the connector development environment](https://help.boomi.com/bundle/connectors/page/int-Setting_up_the_custom_connector_development_environment.html)

### Environment

* Java >= 8
* Dell Boomi SDK, please follow the instructions mentioned above
* Eclipse / IntelliJ
* Maven or Gradle
* Github
* Travis-CI https://travis-ci.org/getting_started

Furthermore, you need access to a BrandMaker instance with a user, who has access rights to Marketing Planner and Job Manager.
