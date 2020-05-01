package com.czk.Spring.annotation.Myinterface;

import com.czk.Spring.annotation.ZJPOJO.ZJRole;
import org.springframework.stereotype.Component;
@Component
public interface RoleService {
    ZJRole getRole();
}
