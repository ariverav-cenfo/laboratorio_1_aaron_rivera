CREATE FUNCTION producto_actualizar(
    p_id_producto BIGINT,
    p_nombre_producto varchar(100),
    p_descrcipcion_producto varchar(250),
    p_precio numeric(38,2),
    p_stock INTEGER,
    p_categoria_id BIGINT
)
    RETURNS SETOF producto
LANGUAGE plpgsql
AS $$
BEGIN
RETURN QUERY
UPDATE producto AS c
SET
nombre_producto = p_nombre_producto,
descrcipcion_producto = p_descrcipcion_producto,
precio = p_precio,
stock = p_stock,
categoria_id = p_categoria_id
WHERE c.id_producto = p_id_producto
    RETURNING c.*;
END;
$$;