CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerClientes`(IN in_apellidos VARCHAR(32))
BEGIN
    SELECT * 
    FROM CLIENTES
    WHERE apellidos = in_apellidos;
END