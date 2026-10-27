pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                echo 'Building Vehicle Accident Detection System'
                bat 'mvn clean package'
            }
        }

        stage('Automated Testing') {
            steps {
                echo 'Running accident scenario tests'
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Generate Event Report') {
            steps {
                echo 'Generating event analysis report'
                bat 'mvn exec:java'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'event-analysis-report.txt,target/surefire-reports/*.xml,target/*.jar',
                                 allowEmptyArchive: false
            }
        }
    }

    post {
        success {
            echo 'Vehicle Accident Detection pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}