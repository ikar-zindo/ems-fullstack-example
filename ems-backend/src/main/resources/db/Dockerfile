FROM mysql:8.0.33

ENV MYSQL_DATABASE=ems
ENV MYSQL_ROOT_PASSWORD=12345

COPY init-db.sql /docker-entrypoint-initdb.d/

EXPOSE 3306