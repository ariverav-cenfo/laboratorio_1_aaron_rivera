CREATE FUNCTION categoria_eliminar(
    p_CategoriaId BIGINT
)
RETURNS BOOLEAN
LANGUAGE plpgsql
AS $$
DECLARE
    v_CategoriaEliminada BOOLEAN;
BEGIN
    DELETE FROM categoria
    WHERE categoria_id = p_categoria_id;
    v_CategoriaEliminada := FOUND;
    RETURN v_CategoriaEliminada;
END;
$$;