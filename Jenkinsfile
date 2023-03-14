pipeline {
    agent any

    triggers {
            parameterizedCron('''
                50 20 * * * %SUITE_NAME=Smoke.xml
                55 20 * * * %SUITE_NAME=Regression.xml
            ''')
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    parameters {
     gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
     string(name: 'SUITE_NAME', defaultValue: 'Smoke.xml')
     choice(choices: ['chrome', 'fireFox'], description: 'Select a browser', name: 'BROWSER',)
     booleanParam (
                   defaultValue: false,
                   description: 'Headless',
                   name: 'HEADLESS')
    }

    stages {
        stage('Run Selenium Tests') {
            steps {
                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}", url: 'https://github.com/CptPerebey/QA22_Vereshako_PrestaShop_Diplom'

                // Run Maven on a Unix agent.
                bat "mvn -Dmaven.test.failure.ignore=true -DsuiteXmlFile=${params.SUITE_NAME} -Dbrowser=${params.BROWSER} -Dheadless=${params.HEADLESS} clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Generate Allure report') {
            steps {
                 script {
                    allure([
                     includeProperties: false,
                     jdk: '',
                     properties: [],
                     reportBuildPolicy: 'ALWAYS',
                     results: [[path: 'target/allure-results']]
                     ])
                }
            }
        }
    }
}
