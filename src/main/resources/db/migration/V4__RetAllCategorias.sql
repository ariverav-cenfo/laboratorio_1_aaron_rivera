CREATE FUNCTION categoria_listar()
RETURNS SETOF categoria
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT c.*
    FROM categoria AS c
    ORDER BY c.categoria_id;
END;
$$;