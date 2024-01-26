FROM nginx:1.25-alpine

RUN adduser -S hfauchery -G root

RUN rm -rf /usr/share/nginx/html/*

COPY ./dist/asa-ng /usr/share/nginx/html
RUN chown hfauchery:root /usr/share/nginx/html
RUN chown hfauchery:root /var/cache/nginx/
RUN chown hfauchery:root /var/run/

USER hfauchery

ENTRYPOINT ["nginx"]
CMD ["-g", "daemon off;"]