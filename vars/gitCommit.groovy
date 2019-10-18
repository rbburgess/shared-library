def call(String commitMessage) {
    sh 'git config user.email "test@gmail.com"'
    sh 'git config user.name "Robert"'
    sh 'git add --all'
    sh "git commit -m \"${commitMessage}\""
    sh 'git push' 
}