def call(String commitMessage) {
    sh 'git add --all'
    sh "git commit -m \"${commitMessage}\""
    sh 'git push' 
}