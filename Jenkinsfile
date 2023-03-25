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
        stage("deploy") {
            input {
                // to give user input
                message "Select the env to deploy to"
                ok "Done"
                parameters {
                    // The scope of the parameter defined below is only for this stage
                    choice(name:'ENV', choices:['Dev', 'Prod'])
                }
            }
            steps {
                script {
                    // we can also give the user input to the variable inside the script block
                    // here the env variable can be used globally in other stages as well 
                    en.env = input message: "Select the env to deploy to", ok: "Done", parameters: [choice(name:'ENV', choices:['Dev', 'Prod'])]
                    echo "deploying to ${ENV}"
                    echo "deploying to ${env}"
                }
            }
        }
    }
}
