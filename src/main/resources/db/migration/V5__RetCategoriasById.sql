CREATE FUNCTION categoria_find_byId(
    p_CategoriaId BIGINT
)
RETURNS SETOF categoria
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT c.*
    FROM categoria AS c
        WHERE c.categoria_id = p_categoria_id;
END;
$$;