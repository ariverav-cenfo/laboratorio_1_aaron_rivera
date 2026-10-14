CREATE FUNCTION producto_find_byId(
    p_id_producto BIGINT
)
    RETURNS SETOF producto
LANGUAGE plpgsql
AS $$
BEGIN
RETURN QUERY
SELECT c.*
FROM producto AS c
WHERE c.id_producto = p_id_producto;
END;
$$;