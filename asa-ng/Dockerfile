FROM nginx:2.15.1-alpine

ARG WORKDIR = app/

RUN groupadd -r owners && useradd -g owners hfauchery
USER hfauchery

COPY /dist/asa-ng /usr/share/nginx/html