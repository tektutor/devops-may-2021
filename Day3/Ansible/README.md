### Preparing Ubuntu Ansible Custom Docker Image
```
cd Day3/Ansible/ubuntu-ansible
ssh-keygen
cp /root/.ssh/id_rsa.pub authorized_keys

docker build -t tektutor/ansible-ubuntu .
```

### Create ansible node containers
```
docker run -d --name ubuntu1 --hostname ubuntu1 -p 8001:80 -p 2001:22 tektutor/ansible-ubuntu
docker run -d --name ubuntu2 --hostname ubuntu2 -p 8002:80 -p 2002:22 tektutor/ansible-ubuntu
```

### See if the ubuntu1 and ubuntu2 containers are runnings
```
docker ps
```

### Test if you can do ssh without password
```
ssh -p 2001 root@localhost
ssh -p 2002 root@localhost
```
When it prompts with a question "Are you sure, do you want to continue connecting yes/no",  type yes
