pipeline {
    agent {
        docker { 
            image 'maven:3.9.3-openjdk-17'  // Maven + JDK preinstalled
            args '-v /root/.m2:/root/.m2'   // optional: cache Maven repo
        }
    }
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Build') {
            steps { sh 'mvn clean package' }
        }
        stage('Archive Artifacts') {
            steps { archiveArtifacts artifacts: 'target/*.jar', fingerprint: true }
        }
    }
}

