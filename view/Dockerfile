# Build stage for React app
FROM node:20.10.0 as build
WORKDIR /view
COPY package.json ./
RUN npm install
COPY . ./
RUN npm run build

# Nginx stage to serve React app
FROM nginx:alpine
COPY --from=build /view/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
