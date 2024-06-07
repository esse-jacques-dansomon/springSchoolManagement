# Deploy Application with Postgres

```shell
alias k="kubectl --namespace webapps"


k create -f ns.yaml
k create -f postgres-configmap.yaml -n webapps
k create -f postgres-credentials.yaml -n webapps
k create -f psql-pv.yaml -n webapps
k create -f psql-claim.yaml -n webapps
k create -f psql-deployment.yaml -n webapps
k create -f psql-service.yaml -n webapps

k create -f app-deployment.yaml -n webapps
k get all -n webapps
k delete -f app-deployment.yaml -n webapps

k describe pod schoolmanagement-deploy-69884f7888-qk55q  -n webapps
k logs schoolmanagement-deploy-69884f7888-qk55q  -n webapps
k get deployments, pods -n webapps


```