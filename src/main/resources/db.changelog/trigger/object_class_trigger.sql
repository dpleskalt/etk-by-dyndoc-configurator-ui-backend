CREATE TRIGGER audit_update
    BEFORE UPDATE
    ON iehr.thr_object_class
    FOR EACH ROW
    WHEN (OLD.* IS DISTINCT FROM NEW.*)
EXECUTE PROCEDURE iehr.object_class_updated();

CREATE TRIGGER audit_create
    BEFORE INSERT
    ON iehr.thr_object_class
    FOR EACH ROW
    WHEN (NEW.creation_date IS NULL)
EXECUTE PROCEDURE iehr.object_class_created();

CREATE TRIGGER created_by
    BEFORE INSERT
    ON iehr.thr_object_class
    FOR EACH ROW
    WHEN (NEW.created_by IS NULL)
EXECUTE PROCEDURE iehr.object_class_created_by();

CREATE TRIGGER last_updated_by
    BEFORE UPDATE
    ON iehr.thr_object_class
    FOR EACH ROW
    WHEN (OLD.* IS DISTINCT FROM NEW.*)
EXECUTE PROCEDURE iehr.object_class_last_updated_by();
