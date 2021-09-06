module Clientes{
    exports com.jorgerubira.hiberusprojectclientes.interfaces;
    exports com.jorgerubira.hiberusprojectclientes;
    provides com.jorgerubira.hiberusprojectclientes.interfaces.ClienteInterfaz 
             with com.jorgerubira.hiberusprojectclientes.services.ClienteServicio;
}
