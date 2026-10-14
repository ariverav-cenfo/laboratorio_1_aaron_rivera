CREATE FUNCTION producto_crear(
    p_nombre_producto varchar(100),
    p_descrcipcion_producto varchar(250),
    p_precio numeric(38,2),
    p_stock INTEGER,
    p_categoria_id BIGINT
)
    RETURNS BIGINT
    LANGUAGE plpgsql
AS $$
DECLARE
v_id_producto BIGINT;
BEGIN
INSERT INTO producto(
    nombre_producto,
    descrcipcion_producto,
    precio,
    stock,
    categoria_id
)VALUES (
            p_nombre_producto,
            p_descrcipcion_producto,
            p_precio,
            p_stock,
            p_categoria_id
        )RETURNING id_producto into v_id_producto;
RETURN v_id_producto;
END;
$$;