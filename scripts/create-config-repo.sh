#!/bin/bash

if [ $# -lt 2 ]; then
    echo "       "
    echo "usage: ./create-config-repo.sh ADMIN_USERNAME_PWD GITLAB_ACC_TOKEN GITLAB_USERNAMES"
    echo "       "
    echo "       ADMIN_USERNAME_PWD - admin user for the config server in format user:password"
    echo "       GITLAB_ACC_TOKEN   - the access token for your gitlab user."
    echo "       GITLAB_USERNAMES   - comma separated list of usernames to associate to new repo."
    exit 1
fi

ADMIN_USERNAME_PWD=$1
GITLAB_ACC_TOKEN=$2
GITLAB_USERNAMES=$3

curl -X POST "http://$ADMIN_USERNAME_PWD@configserver-dev.apps.ad.corelogic.asia/admin/repo/dppr-config?accessToken=$GITLAB_ACC_TOKEN&username=$GITLAB_USERNAMES"

echo "Configuration repository created at: http://gitlab.ad.corelogic.asia/SpringCloudConfig/dppr-config"