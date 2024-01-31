FROM nginx:1.25-alpine

RUN rm -rf /usr/share/nginx/html/*
RUN rm /etc/nginx/nginx.conf
RUN rm /etc/nginx/conf.d/default.conf

COPY nginx/nginx.conf /etc/nginx/nginx.conf
COPY nginx/default.conf /etc/nginx/conf.d/default.conf

COPY --chown=nginx:nginx ./dist/asa-ng /usr/share/nginx/html

RUN chown nginx:nginx /var/cache/nginx/
RUN chown nginx:nginx /var/run/

USER nginx

ENTRYPOINT ["nginx"]
CMD ["-g", "daemon off;"]