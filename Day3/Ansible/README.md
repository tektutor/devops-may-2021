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

### Change ownership of devops-may-2021 folder to 'devops' user. Do this as root user
```
cd /home/devops
chown -R devops devops-may-2021
```

From Applications Menu --> Programming --> Sublime Text --> Open Folder --> /home/devops/devops-may-2021/Day3/Ansible
Open the hosts file and type the below content before saving
```
[all]
ubuntu1 ansible_user=root ansible_port=2001 ansible_host=localhost ansible_private_key_file=/root/.ssh/id_rsa
ubuntu2 ansible_user=root ansible_port=2002 ansible_host=localhost ansible_private_key_file=/root/.ssh/id_rsa
```

### What exactly ansible ping does
```
ansible -i hosts ubuntu1 -m ping
```

1. Ansible adhoc utility will pick the ssh connection details for ubuntu1 ansible node from the hosts(inventory) file.
2. Ansible adhoc utility will create tmp directory in ACM- Ansible Controller Machine and a corresponding tmp directory
   on the Ansible node.
3. Using sftp ansible copies the transpiled ping.py python script from ACM tmp folder to Ansible Node tmp folder
4. ansible will give execute permission to the ping.py script on the ansible node
5. ansible will execute the python script on the ansible node /usr/bin/python3 /root/.ansible/tmpxxxxxx/xxxxAnsiballz_ping.py
6. ansible will collect the reponse(output) of the python script 
7. On the ACM machine it gives a summary of the output

