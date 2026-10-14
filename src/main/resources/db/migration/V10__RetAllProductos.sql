CREATE FUNCTION producto_listar()
    RETURNS SETOF producto
LANGUAGE plpgsql
AS $$
BEGIN
RETURN QUERY
SELECT c.*
FROM producto AS c
ORDER BY c.id_producto;
END;
$$;