# Mod-Elf

Copyright (C) 2017 The Open Library Foundation

This software is distributed under the terms of the Apache License,
Version 2.0. See the file "[LICENSE](LICENSE)" for more information.

## Introduction

Mod-Elf is an Okapi module that provides the webservices for a electronic loanable form.

## Configure Mod-Elf

In order for mod-elf to send e-mails, you will need to configure smtp settings.

1. Open EmailComposer.java
    ```bash
    code ~/Desktop/folio/bl/mod-elf/src/main/java/org/folio/rest/utils/EmailComposer.java
    ```
1. Provide your smtp username, password, host, and port.
    ```java
    private final String SMTP_USERNAME = "username";
    private final String SMTP_PASSWORD = "password";
    private final String SMTP_HOST = "smtp.gmail.com";
    private final String SMTP_PORT = "587";
    ```
1. Customize the checkin and checkout e-mail confirmations by changing the variables in the e-mail settings section.
    ```java
    /** e-mail settings */
	private final String LIBRARY_NAME = "Datalogisk Institut";
	private final String LIBRARY_PHONE = "29979812";
	private final String HOME_PAGE = "http://diku.dk";
	private final String BANNER = "http://diku.dk/english/about/topgrafik/AboutDIKU_Top_505px.jpg?size=700x267";
	private final String FB_ICON = "https://images2.imgbox.com/dd/7b/dERSD77S_o.png";
	private final String FB_LINK = "https://www.facebook.com/universitet";
	private final String TWITTER_ICON = "https://images2.imgbox.com/17/29/H9U3G6if_o.png";
	private final String TWITTER_LINK = "https://twitter.com/uni_copenhagen";
    ```

## Install Mod-Elf

```bash
mvn clean install
```

## Install Mod-Elf Docker Image

```bash
docker rmi mod-elf
docker container prune
docker build -t mod-elf .
```

## Deploy as Okapi Module: Postgresql Server, All Modules

1. Set-up environment (see 0-installation docs).
    ```bash
    sudo ifconfig lo0 alias 10.0.2.15
    brew services restart postgresql@9.6
    open -a Docker
    # wait for Docker to start before running next cmd
    docker run -d -v /var/run/docker.sock:/var/run/docker.sock -p 127.0.0.1:4243:4243 bobrik/socat TCP-LISTEN:4243,fork UNIX-CONNECT:/var/run/docker.sock
    ```
1. Deploy Okapi
    ```bash
    cd ~/Desktop/folio
    java \
          -Dstorage=postgres \
          -Dpostgres_host=localhost \
          -Dpostgres_port=5432 \
          -Dpostgres_user=okapi \
          -Dpostgres_password=okapi25 \
          -Dpostgres_database=okapi \
          -Dhost=10.0.2.15 \
          -Dport=9130 \
          -Dport_start=9131 \
          -Dport_end=9151 \
          -DdockerURL=http://localhost:4243 \
          -Dokapiurl=http://10.0.2.15:9130 \
          -jar bl/okapi/okapi-core/target/okapi-core-fat.jar dev
    ```
1. Deploy Okapi modules (necessary for permissions-module-4.0.4).
    ```bash
    source activate folio
    python ~/Desktop/folio/bl/dev-ops/deploy_modules.py
    source deactivate folio
    ```
1. Change to mod-elf directory.
    ```bash
    cd ~/Desktop/folio/bl/mod-elf
    ```
1. *Only Once*: Register `mod-elf`.
    ```bash
    curl -w '\n' -X POST -D -   \
        -H "Content-type: application/json"   \
        -d @target/ModuleDescriptor.json \
        http://localhost:9130/_/proxy/modules
    curl http://localhost:9130/_/proxy/modules
    ```
1. Deploy `mod-elf` as a Docker container.
    ```bash
    curl -w '\n' -D - -s \
        -X POST \
        -H "Content-type: application/json" \
        -d @target/DockerDeploymentDescriptor.json  \
        http://localhost:9130/_/discovery/modules
    curl -i -w '\n' -X GET http://localhost:9130/_/discovery/modules
    ```
1. *Only Once*: Enable `mod-elf` for `diku` tenant.
    ```bash
    curl -w '\n' -X POST -D -   \
        -H "Content-type: application/json"   \
        -d @target/EnableDescriptor.json \
        http://localhost:9130/_/proxy/tenants/diku/modules
    curl http://localhost:9130/_/proxy/tenants/diku/modules
    ```
1. Request `itemInfo` through `mod-elf`.
    ```bash
    # LOGIN and get x-okapi-token and use it for the next requests
    curl -i -w '\n' -X POST -H 'X-Okapi-Tenant: diku' \
        -H "Content-type: application/json" \
        -d '{"username": "diku_admin", "password": "admin"}' \
        http://localhost:9130/authn/login

    # GET elf info
    curl -i -w '\n' -X GET \
        -H 'Content-type: application/json' \
        -H 'X-Okapi-Token: [Replace_With_Token]' \
        -H 'X-Okapi-Tenant: diku' 'http://localhost:9130/iteminfo?limit=30&query=itemid%3D%22459afaba-5b39-468d-9072-eb1685e0ddf4%22'
    ```
1. Tear-down
    `ctrl + c` out of okapi and stripes.
    ```bash
    docker kill $(docker ps -q)
    docker container prune
    brew services stop postgresql@9.6
    sudo ifconfig lo0 -alias 10.0.2.15
    ```

Note: Launch descriptor has a path relative to the directory that `java -jar okapi-core-fat.jar` was executed in (likely `~/Desktop/folio`).

## Reference

1. Unregister mod-elf from Okapi gateway.
    ```bash
    # undeploy mod-elf
    curl -w '\n' -X DELETE  -D - http://localhost:9130/_/discovery/modules/mod-elf-1.0.0/10.0.2.15-9143
    # disable mod-elf for diku
    curl -w '\n' -X DELETE  -D - http://localhost:9130/_/proxy/tenants/diku/modules/mod-elf-1.0.0
    # unregister mod-elf
    curl -w '\n' -X DELETE  -D - http://localhost:9130/_/proxy/modules/mod-elf-1.0.0
    ```
1. List registered modules.
    ```bash
    # list deployed modules
    curl -i -w '\n' -X GET http://localhost:9130/_/discovery/modules
    # list modules enabled for diku user
    curl -i -w '\n' -X GET http://localhost:9130/_/proxy/tenants/diku/modules
    # list modules registered with okapi
    curl -i -w '\n' -X GET http://localhost:9130/_/proxy/modules
    ```
