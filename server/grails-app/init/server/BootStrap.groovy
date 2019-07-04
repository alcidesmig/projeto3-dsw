package server

import br.ufscar.dc.dsw.Promocao
import br.ufscar.dc.dsw.Site
import br.ufscar.dc.dsw.Teatro
import br.ufscar.dc.dsw.User
import br.ufscar.dc.dsw.UserRole
import br.ufscar.dc.dsw.Role

class BootStrap {

    def init = { servletContext ->

        Role admin = new Role(authority: 'ROLE_ADMIN').save()
        Role site = new Role(authority: 'ROLE_SITE').save()
        Role teatro = new Role(authority: 'ROLE_TEATRO').save()

        User user = new User(username: "admin", password: "admin").save()
        UserRole.create(user, admin, true)

    }
    def destroy = {
    }
}
