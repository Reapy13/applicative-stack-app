FROM nginx:1.25-alpine

RUN addgroup -S owners \
    && adduser -S hfauchery -G owners

RUN rm -rf /usr/share/nginx/html/*

COPY --chown=hfauchery:owners ./dist/asa-ng /usr/share/nginx/html

USER hfauchery

CMD ["nginx", "-g", "daemon off;"]