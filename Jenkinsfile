// defining the variable holding the groovy script here in order to be accessible in every stage (i.e) globally
def gv 

pipeline {
    parameters {
        choice(name:'VERSION', choices:['1.1.0', '1.2.0'])
        booleanParam(name:'executeTests', defaultValue: true)
    }
    agent any
    stages {
        stage("init") {
            // init stage is used to initialize the goroovy script
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage("test") {
            steps {
                script {
                    gv.testApp()
                }
            }
        }
    }
}