CREATE TABLE if not exists reservations_activities (
    id BIGINT NOT NULL AUTO_INCREMENT,
    reservation_id BIGINT NOT NULL,
    activity_id BIGINT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (reservation_id) REFERENCES reservations(id),
    FOREIGN KEY (activity_id) REFERENCES activities(id)
);