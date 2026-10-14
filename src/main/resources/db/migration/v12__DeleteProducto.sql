CREATE FUNCTION producto_eliminar(
    p_id_producto BIGINT
)
    RETURNS BOOLEAN
    LANGUAGE plpgsql
AS $$
DECLARE
v_ProductoEliminado BOOLEAN;
BEGIN
DELETE FROM producto
WHERE id_producto = p_id_producto;
v_ProductoEliminado := FOUND;
RETURN v_ProductoEliminado;
END;
$$;