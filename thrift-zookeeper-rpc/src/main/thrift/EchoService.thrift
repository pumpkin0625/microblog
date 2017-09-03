namespace java com.zyn.microblog.thrift.rpc.demo
service EchoSerivce
{
	string echo(1: string msg);
}