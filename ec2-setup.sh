#!/bin/bash
# Update and install dependencies
sudo apt update
sudo apt install -y git curl unzip

# Install Docker
curl -fsSL https://get.docker.com -o get-docker.sh
sudo sh get-docker.sh
sudo usermod -aG docker ubuntu

# Start and enable Docker
sudo systemctl enable docker
sudo systemctl start docker

# Clean up
rm get-docker.sh

echo "=========================================================="
echo "Docker installed successfully!"
echo "Please log out and log back in, or run 'newgrp docker' to apply group changes."
echo "After that, you can run:"
echo "git clone <your-repo-url>"
echo "cd QuantityMeasurementApp"
echo "nano .env  # Add DB_PASSWORD, GOOGLE_CLIENT_ID, GOOGLE_CLIENT_SECRET"
echo "docker compose up -d --build"
echo "=========================================================="
