/*
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/n-sathya/selenium-testng-framework.git'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn clean test -Dheadless=true'
            }
        }
        stage('Generate Allure Report') {
            steps {
                sh 'mvn allure:report'
            }
        }
    }
} */

pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/n-sathya/selenium-testng-framework.git'
            }
        }
        stage('Run Tests') {
            steps {
                sh "mvn clean test -Dheadless=true \"-Dcucumber.filter.tags=${env.CUCUMBER_TAG}\""
            }
        }
        stage('Generate Allure Report') {
            steps {
                sh 'mvn allure:report'
            }
        }
    }
}
