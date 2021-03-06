package io.mycat.mysql.state.backend;


import io.mycat.backend.MySQLBackendConnection;
import io.mycat.common.StateMachine;
import io.mycat.mysql.state.AbstractMysqlConnectionState;
import io.mycat.net2.Connection;


/**
 * 初始状态
 *
 * @author ynfeng
 */
public class BackendInitialState extends AbstractMysqlConnectionState {

    public static final BackendInitialState INSTANCE = new BackendInitialState();

    private BackendInitialState() {
    }


    /**
     * 后端连接在初始状态下不做任何动作，转到至连接中状态
     */
    @Override
    public boolean handle(StateMachine stateMachine, Connection connection, Object attachment) {
        MySQLBackendConnection mySQLBackendConnection = (MySQLBackendConnection) connection;
        mySQLBackendConnection.getProtocolStateMachine().setNextState(BackendConnectingState.INSTANCE);
        return true;
    }
}
