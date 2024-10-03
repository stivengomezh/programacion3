package com.edu.umanizales.first_api.service;

import com.edu.umanizales.first_api.model.Kid;
import com.edu.umanizales.first_api.model.ListSEModel;
import com.edu.umanizales.first_api.model.Node;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.security.PrivateKey;
import java.util.List;

@Service
@Data
public class ListSEService {
    private ListSEModel listSE;
    private ListSEModel copyList;

    @PostConstruct
    public void init(){
        listSE = new ListSEModel();
    }
    public Node showKids(){
        return listSE.getHead();
    }
}
