### Preparing Ubuntu Ansible Custom Docker Image
```
cd devops-may-2021/Day3/Ansible/ubuntu-ansible
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
```
cd devops-may-2021/Day3/Ansible
touch hosts
```

From Applications Menu --> Programming --> Sublime Text --> Open Folder --> /home/devops/devops-may-2021/Day3/Ansible
Open the hosts file and type the below content before saving
```
[all]
ubuntu1 ansible_user=root ansible_port=2001 ansible_host=localhost ansible_private_key_file=/root/.ssh/id_rsa
ubuntu2 ansible_user=root ansible_port=2002 ansible_host=localhost ansible_private_key_file=/root/.ssh/id_rsa
```

