#!/bin/bash
set -xe


# Copy war file from S3 bucket to tomcat webapp folder
aws s3 cp s3://codedeploystack-webappdeploymentbucket-uf70gl618r4m/demo-0.0.1-SNAPSHOT.jar /usr/local/tomcat9/webapps/demo-0.0.1-SNAPSHOT.jars


# Ensure the ownership permissions are correct.
chown -R tomcat:tomcat /usr/local/tomcat9/webapps