```groovy
pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                echo 'Building Vehicle Accident Detection System'
                bat '"C:/Users/acer/Downloads/apache-maven-3.10.0-bin/apache-maven-3.10.0/bin/mvn.cmd" clean package'
            }
        }

        stage('Automated Testing') {
            steps {
                echo 'Running accident scenario tests'
                bat '"C:/Users/acer/Downloads/apache-maven-3.10.0-bin/apache-maven-3.10.0/bin/mvn.cmd" test'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Generate Event Report') {
            steps {
                echo 'Generating event analysis report'
                bat '"C:/Users/acer/Downloads/apache-maven-3.10.0-bin/apache-maven-3.10.0/bin/mvn.cmd" exec:java'
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
```