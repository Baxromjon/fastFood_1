import {Button, Modal} from "reactstrap";


export default ({showModal, id, cancel}) => {
    return <Modal isOpen={showModal} modalClassName="confirm-modal"
                  className="confirm-moda-content" toggle={cancel}>
        {id ? <div className="row">
            <img src={"http://localhost:8090/api/attachment" + id} className="img-fluid" alt=""/>
            <Button onClick={cancel} className="btn-block">Close</Button>
        </div> : ''}
    </Modal>
}
