pipeline {
    agent any
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


