# Local Quick Start guide

&nbsp;
## Requirements:

### Windows 10/11
- WSL2
- Docker Desktop

### Linux / macOS
- Docker Desktop

> **Resources:**

- [WSL2 Installation guide here.](https://docs.microsoft.com/en-us/windows/wsl/install)

- [Docker Desktop download here.](https://docs.docker.com/get-docker/)

&nbsp;
## Installation Steps:

1. Clone repository
```console
foo@bar:~$ git clone https://github.com/StefanoBavota/aule-web.git
```

2. Navigate to the folder
```console
foo@bar:~$ cd aule-web
```

3. Create local environment file
```console
foo@bar:~/aule-web$ cp .env.local .env
```

5. Generate Vendor folder
```console
foo@bar:~/aule-web$ docker run --rm \
    -u "$(id -u):$(id -g)" \
    -v "$(pwd):/var/www/html" \
    -w /var/www/html \
    laravelsail/php82-composer:latest \
    composer install --ignore-platform-reqs
```

Note: [Info about the last command here](https://laravel.com/docs/10.x/sail#installing-composer-dependencies-for-existing-projects).

Note: [You can configure an alias for the sail binary using the guide here.](https://laravel.com/docs/10.x/sail#configuring-a-shell-alias)

6. Run the containers
```console
foo@bar:~/aule-web$ ./vendor/bin/sail up -d
```

7. Run migrations
```console
foo@bar:~/aule-web$ ./vendor/bin/sail artisan migrate
```

8. Run seeders
```console
foo@bar:~/aule-web$ ./vendor/bin/sail artisan db:seed
```

&nbsp;
## Execution Steps:

1. Start the project
```console
foo@bar:~/aule-web$ ./vendor/bin/sail up -d
```

Project will be available at: [localhost](http://localhost)

All available routes are defined in /routes/api.php

2. Stop the project
```console
foo@bar:~/aule-web$ ./vendor/bin/sail down
```