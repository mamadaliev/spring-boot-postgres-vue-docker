FROM node:lts-alpine
RUN npm install -g http-server
WORKDIR /app/frontend
COPY package*.json ./
RUN npm install --production
COPY . .
RUN npm run build
CMD ["http-server", "dist", "-p", "3000"]
