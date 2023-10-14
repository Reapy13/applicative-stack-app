FROM nginx:1.25-alpine

RUN addgroup owners && adduser hfauchery -G owners

RUN rm -rf /usr/share/nginx/html/*

COPY --chown=hfauchery:owners ./dist/asa-ng /usr/share/nginx/html

USER hfauchery

CMD ["nginx"]