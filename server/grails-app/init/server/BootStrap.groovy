package server

import br.ufscar.dc.dsw.Promocao
import br.ufscar.dc.dsw.Site
import br.ufscar.dc.dsw.Sala
import br.ufscar.dc.dsw.User
import br.ufscar.dc.dsw.UserRole
import br.ufscar.dc.dsw.Role



class BootStrap {

    def init = { servletContext ->

        Role admin = new Role(authority: 'ROLE_ADMIN').save()
        User user = new User(username: "admin", password: "admin").save()
        UserRole.create(user, admin, true)
    }
    def destroy = {
    }
}
