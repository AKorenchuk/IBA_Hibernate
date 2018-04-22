package com.javacodegeeks.snippets.enterprise.hibernate.service;

import com.javacodegeeks.snippets.enterprise.hibernate.model.Client;
import com.javacodegeeks.snippets.enterprise.hibernate.service.helper.GenericService;

    public class ClientService extends GenericService<Client> {

        public ClientService() {
            super("from Client",Client.class);
        }


    }
