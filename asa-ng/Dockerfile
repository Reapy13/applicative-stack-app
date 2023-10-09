FROM nginx:1.25-alpine

RUN rm -rf /usr/share/nginx/html/*

COPY ./dist/asa-ng /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]