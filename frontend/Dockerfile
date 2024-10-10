# Use Node.js 20.18.0 as the base image
FROM node:20.18.0-alpine

# Set the working directory
WORKDIR /app

# Copy the package.json and package-lock.json files
COPY package*.json ./

# Install dependencies using pnpm
RUN npm install -g pnpm && pnpm install

# Copy the rest of the application code
COPY . .

# Build the Vue.js application
RUN pnpm run build

# Use a lightweight web server to serve the built files
FROM nginx:alpine
COPY --from=0 /app/dist /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx server
CMD ["nginx", "-g", "daemon off;"]